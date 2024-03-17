import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

class JonsonAlgorithm {
    fun copyArray(source: IntArray): IntArray {
        return source.copyOfRange(0, source.size)
    }
    @Composable
    fun FirstStep(matrix: Array<IntArray>){
        var fstInd = mutableListOf<Int>()

        var matrixCopy : IntArray
        matrixCopy = copyArray(matrix[0])
        matrixCopy.sort()

        for (i in matrixCopy)
        {
            for (j in 0 until 1){
                for (k in 0 until matrix[j].size){
                    if (matrix[j][k] == i)
                        fstInd.add(k+1)
                }
            }
        }
        Column() {
        Row { Text(
            text = "${fstInd.distinct()}",
            fontSize = 32.sp
        )
    }}
    }
    @Composable
    fun secondStep(matrix: Array<IntArray>){
        val fstInd = mutableListOf<Int>()
        val matrixCopy : IntArray
        matrixCopy = copyArray(matrix[matrix.size-1])
        matrixCopy.sortDescending()
        for (i in matrixCopy)
        {
            for (j in matrix.size - 1 until matrix.size){
                for (k in 0 until matrix[j].size){
                    if (matrix[j][k] == i)
                        fstInd.add(k+1)
                }
            }
        }
        Column() {
            Row { Text(
                text = "........................${fstInd.distinct()}",
                fontSize = 32.sp
            )
            }
    }
    }
    @Composable
    fun thirdStep(matrix: Array<IntArray>){}
    @Composable
    fun fourStep(matrix: Array<IntArray>){
        val fstInd = mutableListOf<Int>()
        val sum = mutableListOf<Int>()
            for (j in 0  until matrix[0].size){
                var summa = 0
                for (k in 0 until matrix.size){
                     summa += matrix[k][j]
                }
                sum.add(summa)
            }
        val matrixCopy : IntArray
        matrixCopy = copyArray(sum.toIntArray())
        matrixCopy.sortDescending()
        for (i in matrixCopy)
        {
            for (j in 0 until sum.size){
                    if (sum[j] == i)
                        fstInd.add(j+1)
                }
        }
        Text(
            text = "......................................${fstInd}${sum}", fontSize = 32.sp)
    }

}


