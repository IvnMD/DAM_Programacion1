from __future__ import annotations

from pathlib import Path
import re
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parent.parent
REPORTS = ROOT / "target" / "surefire-reports"
TARGET = ROOT / "target"
SERVICE_DIR = ROOT / "src" / "main" / "java" / "com" / "ejemplo" / "service"
MODEL_DIR = ROOT / "src" / "main" / "java" / "com" / "ejemplo" / "model"

PESOS_TESTS = {
    "cliente": 2.5,
    "vehiculo": 2.0,
    "alquiler": 3.5,
}

PESO_HERENCIA = 0.5

PESOS_DOCUMENTACION = {
    "cliente": 0.5,
    "vehiculo": 0.5,
    "alquiler": 0.5,
}

INTERFACES = {
    "cliente": SERVICE_DIR / "IClienteService.java",
    "vehiculo": SERVICE_DIR / "IVehiculoService.java",
    "alquiler": SERVICE_DIR / "IAlquilerService.java",
}

METODOS_ESPERADOS = {
    "cliente": {
        "create": ["crea", "cliente"],
        "findByDni": ["busca", "dni"],
        "findAll": ["lista", "clientes"],
        "update": ["actualiza", "cliente"],
        "deleteByDni": ["elimina", "dni"],
        "findActivos": ["activos"],
        "findByEmail": ["email"],
    },
    "vehiculo": {
        "create": ["crea", "vehiculo"],
        "findById": ["busca", "identificador"],
        "findAll": ["lista", "vehiculos"],
        "update": ["actualiza", "vehiculo"],
        "deleteById": ["elimina", "identificador"],
        "findByTipo": ["tipo"],
    },
    "alquiler": {
        "create": ["crea", "alquiler"],
        "findById": ["busca", "identificador"],
        "findAll": ["lista", "alquileres"],
        "cancelById": ["cancela", "alquiler"],
        "completeById": ["completa", "alquiler"],
        "findByCliente": ["cliente", "dni"],
        "findByVehiculo": ["vehiculo"],
        "existsActiveRental": ["alquiler", "activo"],
    },
}


def detectar_bloque(nombre_clase: str) -> str:
    nombre = nombre_clase.lower()
    if "cliente" in nombre:
        return "cliente"
    if "vehiculo" in nombre:
        return "vehiculo"
    if "alquiler" in nombre:
        return "alquiler"
    return "otros"


def normalizar_texto(texto: str) -> str:
    reemplazos = str.maketrans("áéíóúÁÉÍÓÚ", "aeiouAEIOU")
    texto = texto.translate(reemplazos).lower()
    texto = re.sub(r"\s+", " ", texto)
    return texto.strip()


def extraer_javadocs_por_metodo(interface_path: Path) -> dict[str, str]:
    if not interface_path.exists():
        return {}
    texto = interface_path.read_text(encoding="utf-8")
    patron = re.compile(
        r"/\*\*(?P<javadoc>[\s\S]*?)\*/\s*(?:public\s+)?[\w<>\[\], ?]+\s+(?P<metodo>\w+)\s*\(",
        flags=re.MULTILINE,
    )
    return {m.group("metodo"): normalizar_texto(m.group("javadoc")) for m in patron.finditer(texto)}


def puntuar_documentacion_interface(interface_path: Path, bloque: str) -> dict:
    esperados = METODOS_ESPERADOS[bloque]
    javadocs = extraer_javadocs_por_metodo(interface_path)
    encontrados, faltantes, sin_javadoc = [], [], []
    for metodo, palabras_clave in esperados.items():
        texto = javadocs.get(metodo)
        if texto is None:
            faltantes.append(metodo)
            sin_javadoc.append(metodo)
            continue
        if all(normalizar_texto(palabra) in texto for palabra in palabras_clave):
            encontrados.append(metodo)
        else:
            faltantes.append(metodo)
    ratio = 0.0 if not esperados else len(encontrados) / len(esperados)
    return {
        "puntos": round(ratio * PESOS_DOCUMENTACION[bloque], 2),
        "encontrados": encontrados,
        "faltantes": faltantes,
        "sin_javadoc": sin_javadoc,
        "ruta": str(interface_path),
    }


def puntuar_documentacion_interfaces() -> dict:
    return {bloque: puntuar_documentacion_interface(ruta, bloque) for bloque, ruta in INTERFACES.items()}


def calcular_resumen_tests(report_files: list[Path]) -> dict:
    resumen = {bloque: {"total": 0, "passed": 0, "failed": 0} for bloque in PESOS_TESTS}
    for file in report_files:
        root = ET.parse(file).getroot()
        bloque = detectar_bloque(root.attrib.get("name", "desconocido"))
        if bloque not in resumen:
            continue
        tests = int(root.attrib.get("tests", 0))
        failed = int(root.attrib.get("failures", 0)) + int(root.attrib.get("errors", 0)) + int(root.attrib.get("skipped", 0))
        passed = max(0, tests - failed)
        resumen[bloque]["total"] += tests
        resumen[bloque]["passed"] += passed
        resumen[bloque]["failed"] += failed
    return resumen


def calcular_nota_bloque(total: int, passed: int, peso_tests: float) -> tuple[float, float]:
    if total == 0:
        return 0.0, 0.0
    ratio = passed / total
    return round(10 * ratio, 2), round(ratio * peso_tests, 2)


def puede_sumar_documentacion(total: int, passed: int) -> bool:
    return total > 0 and (passed / total) >= 0.85


def eliminar_comentarios_java(texto: str) -> str:
    texto = re.sub(r"/\*[\s\S]*?\*/", "", texto)
    texto = re.sub(r"//.*", "", texto)
    return texto


def evaluar_herencia() -> dict:
    persona_path = MODEL_DIR / "Persona.java"
    cliente_path = MODEL_DIR / "Cliente.java"
    resultado = {
        "puntos": 0.0,
        "persona_existe": persona_path.exists(),
        "cliente_existe": cliente_path.exists(),
        "persona_abstracta": False,
        "cliente_extiende_persona": False,
        "detalles": [],
    }
    if not resultado["persona_existe"]:
        resultado["detalles"].append(f"No existe {persona_path}")
    if not resultado["cliente_existe"]:
        resultado["detalles"].append(f"No existe {cliente_path}")
    if resultado["persona_existe"]:
        persona_src = eliminar_comentarios_java(persona_path.read_text(encoding="utf-8"))
        resultado["persona_abstracta"] = bool(re.search(r"\bpublic\s+abstract\s+class\s+Persona\b|\babstract\s+class\s+Persona\b", persona_src))
        if not resultado["persona_abstracta"]:
            resultado["detalles"].append("Persona debe declararse como clase abstracta")
    if resultado["cliente_existe"]:
        cliente_src = eliminar_comentarios_java(cliente_path.read_text(encoding="utf-8"))
        resultado["cliente_extiende_persona"] = bool(re.search(r"\bclass\s+Cliente\s+extends\s+Persona\b", cliente_src))
        if not resultado["cliente_extiende_persona"]:
            resultado["detalles"].append("Cliente debe heredar de Persona mediante extends Persona")
    if resultado["persona_abstracta"] and resultado["cliente_extiende_persona"]:
        resultado["puntos"] = PESO_HERENCIA
        resultado["detalles"].append("Herencia correcta: Persona abstracta y Cliente extends Persona")
    return resultado


def generar_informe() -> str:
    report_files = sorted(REPORTS.glob("TEST-*.xml"))
    resumen = calcular_resumen_tests(report_files)
    documentacion = puntuar_documentacion_interfaces()
    herencia = evaluar_herencia()
    total_nota = 0.0
    subtotales: dict[str, float] = {}

    lineas = [
        "=== CALIFICACION AUTOMATICA POR BLOQUE ===",
        "",
        "Pesos: Cliente  = 3.00 (2.50 tests + 0.50 documentacion)",
        "       Vehiculo = 2.50 (2.00 tests + 0.50 documentacion)",
        "       Alquiler = 4.00 (3.50 tests + 0.50 documentacion)",
        "       Herencia = 0.50 (Persona abstracta + Cliente extends Persona)",
        "",
        "Regla: la documentacion de cada interfaz solo computa si el bloque alcanza al menos el 85% de tests pasados.",
        "",
    ]

    for bloque in ("cliente", "vehiculo", "alquiler"):
        total = resumen[bloque]["total"]
        passed = resumen[bloque]["passed"]
        failed = resumen[bloque]["failed"]
        nota_sobre_10, nota_tests = calcular_nota_bloque(total, passed, PESOS_TESTS[bloque])
        if puede_sumar_documentacion(total, passed):
            nota_doc = documentacion[bloque]["puntos"]
            doc_msg = f"{nota_doc:.2f}/{PESOS_DOCUMENTACION[bloque]:.2f}"
        else:
            nota_doc = 0.0
            doc_msg = f"0.00/{PESOS_DOCUMENTACION[bloque]:.2f} (no computa por no alcanzar 85% de tests)"
        subtotal = round(nota_tests + nota_doc, 2)
        subtotales[bloque] = subtotal
        max_bloque = round(PESOS_TESTS[bloque] + PESOS_DOCUMENTACION[bloque], 2)
        total_nota += subtotal
        lineas.append(f"{bloque.upper()} -> tests totales: {total}, pasados: {passed}, fallados: {failed}")
        lineas.append(f"{bloque.upper()} -> nota tests: {nota_sobre_10:.2f}/10, aportacion tests: {nota_tests:.2f}/{PESOS_TESTS[bloque]:.2f}")
        lineas.append(f"{bloque.upper()} -> documentacion interfaz: {doc_msg}")
        lineas.append(f"{bloque.upper()} -> interfaz revisada: {documentacion[bloque]['ruta']}")
        if documentacion[bloque]["faltantes"]:
            lineas.append(f"{bloque.upper()} -> metodos no documentados correctamente: {', '.join(documentacion[bloque]['faltantes'])}")
        else:
            lineas.append(f"{bloque.upper()} -> interfaz completa para este bloque")
        lineas.append(f"{bloque.upper()} -> subtotal: {subtotal:.2f}/{max_bloque:.2f}")
        lineas.append("")

    total_nota += herencia["puntos"]
    lineas.append("=== HERENCIA ===")
    lineas.append(f"HERENCIA -> Persona existe: {'SI' if herencia['persona_existe'] else 'NO'}")
    lineas.append(f"HERENCIA -> Cliente existe: {'SI' if herencia['cliente_existe'] else 'NO'}")
    lineas.append(f"HERENCIA -> Persona abstracta: {'SI' if herencia['persona_abstracta'] else 'NO'}")
    lineas.append(f"HERENCIA -> Cliente extends Persona: {'SI' if herencia['cliente_extiende_persona'] else 'NO'}")
    lineas.append(f"HERENCIA -> puntuacion: {herencia['puntos']:.2f}/{PESO_HERENCIA:.2f}")
    for detalle in herencia["detalles"]:
        lineas.append(f"HERENCIA -> {detalle}")
    lineas.append("")

    nota_final = round(total_nota, 2)
    lineas.append("=== RESUMEN FINAL ===")
    lineas.append(f"Cliente: {subtotales['cliente']:.2f}/3.00")
    lineas.append(f"Vehiculo: {subtotales['vehiculo']:.2f}/2.50")
    lineas.append(f"Alquiler: {subtotales['alquiler']:.2f}/4.00")
    lineas.append(f"Herencia: {herencia['puntos']:.2f}/0.50")
    lineas.append("")
    lineas.append("Suma por bloques:")
    lineas.append(f"{subtotales['cliente']:.2f} + {subtotales['vehiculo']:.2f} + {subtotales['alquiler']:.2f} + {herencia['puntos']:.2f} = {nota_final:.2f}")
    lineas.append("")
    lineas.append("=== NOTA FINAL ===")
    lineas.append(f"Nota final: {nota_final:.2f}/10")
    return "\n".join(lineas) + "\n"


def main() -> int:
    informe = generar_informe()
    TARGET.mkdir(parents=True, exist_ok=True)
    salida = TARGET / "nota.txt"
    salida.write_text(informe, encoding="utf-8")
    print(informe, end="")
    print(f"Fichero generado: {salida}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
