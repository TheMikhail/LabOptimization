import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object MatrixFactory{
   private fun CreateMatrix(heightSize: Int, widthSize: Int): Array<IntArray>{
       val matrix: Array<IntArray> = Array(heightSize){IntArray(widthSize){0} }
       val countHeight = matrix.size
       val countWidth = matrix[0].size
           for (i in 0 until countHeight) {
               for (j in 0 until countWidth) {
                   matrix[i][j] = (Math.random() * 10).toInt()
               }
           }
       return matrix
   }

    fun create(): Array<IntArray> {
        return CreateMatrix(getHeightSize(), getWidthSize())
    }
    fun getHeightSize(): Int{
        val size = (Math.random() * 10).toInt()
        return if (size == 0)
            1
        else
            size
    }
    fun getWidthSize(): Int{
        val size = (Math.random() * 10).toInt()
        return if (size == 0)
            1
        else
            size
    }


}