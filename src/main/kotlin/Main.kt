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
        Column(modifier = Modifier.padding(bottom = 5.dp), verticalArrangement = Arrangement.Bottom) {
            outputMatrix(matrix.value)
            Button(
                onClick = {matrix.value = MatrixFactory.create()}
            ){
                Text(text = "нажми")
            }
        }

       // JonsonAlgorithm().FirstStep(matrix.value)
       // JonsonAlgorithm().secondStep(matrix.value)
       // JonsonAlgorithm().fourStep(matrix.value)

        //PetrovAlgorithm().FirstStep(matrix.value)
        //PetrovAlgorithm().SecondStep(matrix.value)
        PetrovAlgorithm().SumMatrix(matrix.value)
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

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}
