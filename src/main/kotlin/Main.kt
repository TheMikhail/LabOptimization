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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App() {
    val size = (Math.random() * 50).toInt()
    val wize = (Math.random() * 50).toInt()
    //val size = (10).toInt()
    //val wize = (5).toInt()

    MaterialTheme {

        matrixItem(onButton = {button -> Matrix(size,wize).CreateMatrix()})
        //Matrix(size,wize).CreateMatrix()
        Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Bottom) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Элемент с индексом ${size}|${wize} = " + Matrix(size,wize).matrix[1][4].toString(),fontSize = 32.sp)
            }}
}
}
@Composable
fun matrixItem(onButton: (Boolean) -> Unit){
    TextButton(onClick = {onButton(true)}){
        Text(text = "Нажми чтобы собрать матрицу")
    }
}
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
