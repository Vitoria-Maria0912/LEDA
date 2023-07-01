public class BinarySearchRotatedArrayImplementation implements BinarySearchRotatedArray{

       public int findRotations(int[] array){
           int result = 0;
           if(array != null && array.length > 0){
               result = findRotationsBinary(array, 0, array.length - 1);
          }

          return result;
       }

      private int findRotationsBinary(int[] array, int leftIndex, int rightIndex) {
          int result = 0;
          if(!(leftIndex > rightIndex)){
              int meio = (leftIndex + rightIndex) / 2;

              if(meio < array.length - 1 && array[meio] > array[meio + 1]){
                   result = meio + 1;
              } else {
                  if(array[leftIndex] > array[rightIndex] && array[leftIndex] > array[meio]){
                      result = findRotationsBinary(array, leftIndex, meio - 1);
                  } else {
                      result = findRotationsBinary(array, meio + 1, rightIndex);
                  }
              }
          }

           return result;
      }
  }
