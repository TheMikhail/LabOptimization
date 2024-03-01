import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class Matrix(val heightSize: Int, val widthSize : Int ) {
    val matrix: Array<IntArray> = Array(heightSize){IntArray(widthSize){0} }
    val countHeight = matrix.size
    val countWidth = matrix[0].size
    @Composable
    fun CreateMatrix(){
        val matrix: Array<IntArray> = Array(countHeight) { IntArray(countWidth) }

        Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Top,) {
            for (i in 0 until countHeight) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    for (j in 0 until countWidth) {
                        matrix[i][j] = (Math.random() * 10).toInt()
                        Text(text = "${matrix[i][j]}|")
                    }

                }
            }
        }
    }
}