import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun app() {

    MaterialTheme {
        val initialState = MatrixFactory.create()
        val matrix = remember { mutableStateOf(initialState) }

        val finalMatrixByJonson = remember { mutableStateOf<Array<IntArray>?>(null) }

        val finalMatrixbyPetrov = remember { mutableStateOf<Array<IntArray>?>(null) }
        Column(modifier = Modifier.padding(bottom = 5.dp), verticalArrangement = Arrangement.Bottom) {
            outputMatrix(matrix.value)
            Button(
                onClick = { matrix.value = MatrixFactory.create()
                    finalMatrixByJonson.value = null
                    finalMatrixbyPetrov.value = null
                }
            ) {
                Text(text = "Создать матрицу")
            }
            Button(
                onClick = {
                    finalMatrixByJonson.value = FinalMatrix(matrix.value, JonsonAlgorithm().sumPlaceInStep(
                        JonsonAlgorithm().firstStep(matrix.value),
                        JonsonAlgorithm().secondStep(matrix.value),
                        JonsonAlgorithm().fourStep(matrix.value)))
                    finalMatrixbyPetrov.value = null
                }
            ) {
                Text(text = "Преобразовать методом Джонсона")
            }
            Button(
                onClick = {
                    finalMatrixbyPetrov.value = FinalMatrix(matrix.value, PetrovAlgorithm().finalStep(matrix.value,
                        PetrovAlgorithm().FirstStep(matrix.value),
                        PetrovAlgorithm().SecondStep(matrix.value),
                        PetrovAlgorithm().thirdStep(matrix.value)))
                    finalMatrixByJonson.value = null
                }
            ) {
                Text(text = "Преобразовать методом Петрова - Соколицына")
            }
            finalMatrixByJonson.value?.let { outputFinalMatrix(it) }
            finalMatrixbyPetrov.value?.let { outputFinalMatrix(it) }
        }
    }
}

@Composable
fun outputMatrix(matrix: Array<IntArray>) {
    val countMachine = matrix.size
    val countDetails = matrix[0].size
    Column {
        for (i in 0 until countMachine) {
            Row(
                modifier = Modifier.padding(start = 5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                for (j in 0 until countDetails) {
                    Text(text = "${matrix[i][j]}|")
                }
            }
        }
    }

}

fun FinalMatrix(matrix: Array<IntArray>, r: List<Int>): Array<IntArray> {
    val matrixCopy = matrix.map { innerArray -> innerArray.copyOf() }.toTypedArray()
    val copMatrix = matrix.map { innerArray -> innerArray.copyOf() }.toTypedArray()

    for (n in 0 until r.size) {
        for (i in 0 until matrixCopy.size) {
            for (j in 0 until matrixCopy[0].size) {
                if (r[n] - 1 == j) {
                    matrixCopy[i][n] = copMatrix[i][j]

                }
            }
        }
    }
    return matrixCopy
}
@Composable
fun outputFinalMatrix(matrix: Array<IntArray>) {
    val countMachine = matrix.size
    val countDetails = matrix[0].size
    Column {
        for (i in 0 until countMachine) {
            Row(
                modifier = Modifier.padding(start = 5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                for (j in 0 until countDetails) {
                    Text(text = "${matrix[i][j]}|")
                }
            }
        }
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}


