from pathlib import Path
import os
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parent.parent
REPORTS = ROOT / "target" / "surefire-reports"

# Pesos máximos por capa sobre 10
PESOS = {
    "datos": 4.0,
    "servicio": 4.0,
    "validacion": 1.0,
}

# Punto reservado para documentación de API
PUNTOS_DOCUMENTACION = 1.0


def detectar_capa(nombre_clase: str) -> str:
    nombre = nombre_clase.lower()

    if ".data." in nombre or ".repository." in nombre or ".reader." in nombre:
        return "datos"
    if ".service." in nombre:
        return "servicio"
    if ".validator." in nombre or ".validation." in nombre:
        return "validacion"
    if ".util." in nombre:
        return "utilidades"

    if "data" in nombre or "reader" in nombre or "repository" in nombre:
        return "datos"
    if "service" in nombre:
        return "servicio"
    if "validator" in nombre or "validation" in nombre:
        return "validacion"
    if "util" in nombre:
        return "utilidades"

    return "otros"


def normalizar_puntuacion_documentacion(valor: str) -> float:
    try:
        puntos = float(valor.strip().replace(",", "."))
        return max(0.0, min(PUNTOS_DOCUMENTACION, puntos))
    except (ValueError, AttributeError):
        return 0.0


def leer_documentacion_api_desde_ruta(ruta: Path) -> float:
    if not ruta.exists():
        return 0.0
    return normalizar_puntuacion_documentacion(ruta.read_text(encoding="utf-8"))


def leer_documentacion_api() -> float:
    valor_env = os.getenv("DOCUMENTACION_API")
    if valor_env is not None:
        return normalizar_puntuacion_documentacion(valor_env)

    ruta = ROOT / "target" / "documentacion_api.txt"
    return leer_documentacion_api_desde_ruta(ruta)


def calcular_resumen_desde_reportes(report_files):
    resumen = {}
    total_global = 0
    passed_global = 0
    failed_global = 0

    for file in report_files:
        root = ET.parse(file).getroot()

        suite_name = root.attrib.get("name", "desconocido")
        capa = detectar_capa(suite_name)

        if capa not in resumen:
            resumen[capa] = {
                "total": 0,
                "passed": 0,
                "failed": 0,
            }

        tests = int(root.attrib.get("tests", 0))
        failures = int(root.attrib.get("failures", 0))
        errors = int(root.attrib.get("errors", 0))
        skipped = int(root.attrib.get("skipped", 0))

        failed = failures + errors + skipped
        passed = max(0, tests - failed)

        resumen[capa]["total"] += tests
        resumen[capa]["passed"] += passed
        resumen[capa]["failed"] += failed

        total_global += tests
        passed_global += passed
        failed_global += failed

    return resumen, total_global, passed_global, failed_global


def main():
    files = list(REPORTS.glob("TEST-*.xml"))
    if not files:
        print("No se han encontrado reportes en target/surefire-reports")
        print("Nota automatica final: 0.00 / 10")
        return

    resumen, total_global, passed_global, failed_global = calcular_resumen_desde_reportes(files)

    nota_global_tests = 0.0 if total_global == 0 else round(10 * passed_global / total_global, 2)

    detalle_capas = []
    nota_total_capas = 0.0

    for capa in sorted(resumen.keys()):
        total = resumen[capa]["total"]
        passed = resumen[capa]["passed"]
        failed = resumen[capa]["failed"]

        ratio = 0.0 if total == 0 else passed / total
        nota_sobre_10 = round(10 * ratio, 2)

        peso_maximo = PESOS.get(capa, 0.0)
        nota_ponderada = round(ratio * peso_maximo, 2)
        nota_total_capas += nota_ponderada

        detalle_capas.append({
            "capa": capa,
            "total": total,
            "passed": passed,
            "failed": failed,
            "nota_sobre_10": nota_sobre_10,
            "peso_maximo": peso_maximo,
            "nota_ponderada": nota_ponderada,
        })

    puntos_documentacion = leer_documentacion_api()
    nota_final = round(nota_total_capas + puntos_documentacion, 2)

    out = ROOT / "target" / "nota.txt"
    out.parent.mkdir(parents=True, exist_ok=True)

    lineas = []
    lineas.append("=== CALIFICACION AUTOMATICA POR CAPA ===")
    lineas.append("")
    lineas.append(
        f"GLOBAL TESTS -> tests totales: {total_global}, pasados: {passed_global}, "
        f"fallados: {failed_global}, nota: {nota_global_tests:.2f}/10"
    )
    lineas.append("")
    lineas.append("=== DESGLOSE POR CAPA ===")
    lineas.append("")

    print("=== CALIFICACION AUTOMATICA POR CAPA ===")
    print()
    print(
        f"GLOBAL TESTS -> tests totales: {total_global}, pasados: {passed_global}, "
        f"fallados: {failed_global}, nota: {nota_global_tests:.2f}/10"
    )
    print()
    print("=== DESGLOSE POR CAPA ===")
    print()

    for item in detalle_capas:
        texto = (
            f"{item['capa'].upper()} -> "
            f"tests totales: {item['total']}, "
            f"pasados: {item['passed']}, "
            f"fallados: {item['failed']}, "
            f"nota tests: {item['nota_sobre_10']:.2f}/10, "
            f"peso maximo: {item['peso_maximo']:.2f}, "
            f"aportacion: {item['nota_ponderada']:.2f}"
        )
        lineas.append(texto)
        print(texto)

    lineas.append("")
    lineas.append("=== DOCUMENTACION API ===")
    lineas.append(f"Puntos documentacion API: {puntos_documentacion:.2f}/{PUNTOS_DOCUMENTACION:.2f}")
    lineas.append("")
    lineas.append("=== NOTA FINAL ===")
    lineas.append(f"Nota por capas: {nota_total_capas:.2f}/{sum(PESOS.values()):.2f}")
    lineas.append(f"Nota final: {nota_final:.2f}/10")

    print()
    print("=== DOCUMENTACION API ===")
    print(f"Puntos documentacion API: {puntos_documentacion:.2f}/{PUNTOS_DOCUMENTACION:.2f}")
    print()
    print("=== NOTA FINAL ===")
    print(f"Nota por capas: {nota_total_capas:.2f}/{sum(PESOS.values()):.2f}")
    print(f"Nota final: {nota_final:.2f}/10")

    out.write_text("\n".join(lineas) + "\n", encoding="utf-8")

    print()
    print(f"Fichero generado: {out}")


if __name__ == "__main__":
    main()
