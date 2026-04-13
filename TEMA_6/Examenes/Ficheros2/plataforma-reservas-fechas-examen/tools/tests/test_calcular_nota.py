from pathlib import Path
import sys

# Permite importar calcular_nota.py desde tools/
CURRENT_DIR = Path(__file__).resolve().parent
TOOLS_DIR = CURRENT_DIR.parent
sys.path.insert(0, str(TOOLS_DIR))

from calcular_nota import (
    normalizar_puntuacion_documentacion,
    leer_documentacion_api_desde_ruta,
)


def test_normalizar_documentacion_con_uno():
    assert normalizar_puntuacion_documentacion("1") == 1.0


def test_normalizar_documentacion_con_decimal():
    assert normalizar_puntuacion_documentacion("0.5") == 0.5


def test_normalizar_documentacion_con_coma():
    assert normalizar_puntuacion_documentacion("0,5") == 0.5


def test_normalizar_documentacion_limita_maximo():
    assert normalizar_puntuacion_documentacion("2") == 1.0


def test_normalizar_documentacion_limita_minimo():
    assert normalizar_puntuacion_documentacion("-1") == 0.0


def test_normalizar_documentacion_invalida():
    assert normalizar_puntuacion_documentacion("abc") == 0.0


def test_leer_documentacion_desde_fichero_existente(tmp_path: Path):
    fichero = tmp_path / "documentacion_api.txt"
    fichero.write_text("1", encoding="utf-8")

    assert leer_documentacion_api_desde_ruta(fichero) == 1.0


def test_leer_documentacion_desde_fichero_medio_punto(tmp_path: Path):
    fichero = tmp_path / "documentacion_api.txt"
    fichero.write_text("0.5", encoding="utf-8")

    assert leer_documentacion_api_desde_ruta(fichero) == 0.5


def test_leer_documentacion_desde_fichero_inexistente(tmp_path: Path):
    fichero = tmp_path / "documentacion_api.txt"

    assert leer_documentacion_api_desde_ruta(fichero) == 0.0


def test_leer_documentacion_desde_fichero_invalido(tmp_path: Path):
    fichero = tmp_path / "documentacion_api.txt"
    fichero.write_text("no-numero", encoding="utf-8")

    assert leer_documentacion_api_desde_ruta(fichero) == 0.0
