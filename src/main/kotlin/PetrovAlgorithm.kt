import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp



class PetrovAlgorithm {

    @Composable
    fun SumMatrix(matrix: Array<IntArray>) {

        val sumList = mutableListOf<Int>()
        val matrixCopy = matrix.map { innerArray -> innerArray.copyOf() }.toTypedArray()
        val copMatrix = matrix.map { innerArray -> innerArray.copyOf() }.toTypedArray()


        for (indexRow in 0 until matrix[0].size) {
            var summa = 0
            for (indexColumn in 0 until matrix.size - 1) {
                summa += matrix[indexColumn][indexRow]
            }
            sumList.add(summa)

        }
        Text("$sumList")

        for (n in 0 until FirstStep(matrix).size) {
            for (i in 0 until matrixCopy.size) {
                for (j in 0 until matrixCopy[0].size) {
                    if (FirstStep(matrix)[n] == j)
                        matrixCopy[i][n] = copMatrix[i][j]
                }
            }
        }
        for (i in 0 until 1)
            for (j in 1 until matrixCopy[i].size)
                matrixCopy[i][j] = matrixCopy[i][j] + matrixCopy[i][j - 1]

        for (i in 0 until 1)
            for (j in 1 until matrixCopy.size)
                matrixCopy[j][i] = matrixCopy[j][i] + matrixCopy[j - 1][i]

        for (i in 1 until matrixCopy.size)
            for (j in 1 until matrixCopy[i].size){
                matrixCopy[i][j] = matrixCopy[i][j] + maxOf(matrixCopy[i - 1][j], matrixCopy[i][j - 1])
            }
    }
    @Composable
    fun FirstStep(matrix: Array<IntArray>): MutableList<Int> {
        val outputIndex = mutableListOf<Int>()
        val sumList = mutableListOf<Int>()

        for (j in 0 until matrix[0].size) {
            var summa = 0
            for (k in 0 until matrix.size - 1) {
                summa += matrix[k][j]
            }
            sumList.add(summa)
        }

        val sortedSumList = sumList.sorted().toList()
        for (i in sortedSumList)
            for (j in 0 until sumList.size) {
                if (sumList[j] == i)
                    outputIndex.add(j)
            }

        /* Column {
             Row { Text(
                 text = "........................${outputIndex.distinct()}///${sumList}",
                 fontSize = 32.sp
             )
             }
         }*/

        return outputIndex.distinct().toMutableList()
    }

    @Composable
    fun SecondStep(matrix: Array<IntArray>) {
        val fstInd = mutableListOf<Int>()
        val sum = mutableListOf<Int>()

        for (j in 0 until matrix[0].size) {
            var summa = 0
            for (k in 0 until matrix.size) {
                if (k != 0)
                    summa += matrix[k][j]
            }
            sum.add(summa)
        }
        val s = sum.sortedDescending().toList()
        for (i in s)
            for (j in 0 until sum.size) {
                if (sum[j] == i)
                    fstInd.add(j + 1)
            }

        Column {
            Row {
                Text(
                    text = "........................${fstInd.distinct()}///${sum}",
                    fontSize = 32.sp
                )
            }
        }
    }
}