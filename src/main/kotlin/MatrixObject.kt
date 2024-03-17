import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Matrix


object MatrixFactory:Cloneable{
   private fun CreateMatrix(machineSize: Int, detailsSize: Int): Array<IntArray>{
       val matrix: Array<IntArray> = Array(machineSize){IntArray(detailsSize){0} }
       val countMachine = matrix.size
       val countDetails = matrix[0].size
           for (i in 0 until countMachine) {
               for (j in 0 until countDetails) {
                   matrix[i][j] = (Math.random() * 10).toInt()
               }
           }
       return matrix
   }

    fun create(): Array<IntArray> {
        return CreateMatrix(getMachineSize(), getDetailsSize())
    }
    fun getMachineSize(): Int{
        val size = (Math.random() * 10).toInt()
        return if (size < 0)
            1
        else
            size
    }
    fun getDetailsSize(): Int{
        val size = (Math.random() * 10).toInt()
        return if (size == 0)
            1
        else
            size
    }

}