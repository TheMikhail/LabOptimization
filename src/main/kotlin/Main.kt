import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/*  // val out = MatrixObject.getMatrix()
       val matrix = remember { mutableStateOf(MatrixObject.getMatrix()) }
       matrix.value
       matrixItem(onButton = { button -> matrix.value = MatrixObject.OutputMatrix(matrix) })
       //MatrixObject.OutputMatrix(matrix = MatrixObject.getMatrix())*/
/*fun App() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Top) {
            OutputMatrix(MatrixObject.getMatrix())
        }
        Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Bottom) {
            Button(onClick = {

            }) {
                Text(text = "нажми")
            }
        }
    }
}*/
@Composable
@Preview
fun App() {

    MaterialTheme {
        val initialState = MatrixFactory.create()
        val matrix = remember { mutableStateOf(initialState) }
        Column {
            OutputMatrix(matrix.value)
            Button(
                onClick = {matrix.value = MatrixFactory.create()}
            ){
                Text(text = "нажми")
            }
        }
    }
}
@Composable
fun OutputMatrix(matrix: Array<IntArray>) {
    val countHeight = matrix.size
    val countWidth = matrix[0].size
    Column {
        for (i in 0 until countHeight) {
            Row(
                modifier = Modifier.padding(start = 5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                for (j in 0 until countWidth) {
                    Text(text = "${matrix[i][j]}|")
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
