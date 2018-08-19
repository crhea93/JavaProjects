import java.util.Random;



public class quicksort {
  public static element[] swap(element[] list, int i, int j){
    element temp = list[i];
    list[i] = list[j];
    list[j] = temp;
    return list;
  }
  public static int partition(element[] list, int min, int max){
    element pivot = list[max];
    int low = min;
    for (int j=min;j<max;j++) {
      if (list[j].value<pivot.value){
        swap(list,low,j);
        low += 1;
      }//end if
    }//end for
    swap(list,low,max);
    return low;
  }
  public static element[] sort(element[] list, int min, int max){
      if (min<max){
        int part = partition(list,min,max);
        sort(list, min, part-1);
        sort(list,part+1,max);
      }
      return list;

  }

  //Set up class
  static class element {
    float value;
    int index;
  }

  public static void main(String[] args){
    int num_of_values = 0;
    float min = 0;
    float max = 0;
    // Read in number of elements, min value, and max value
    if (args.length > 0) {
      try {
        num_of_values = Integer.parseInt(args[0]);
        min = Float.parseFloat(args[1]);
        max = Float.parseFloat(args[2]);
      } catch (NumberFormatException e){
        System.exit(1);
      }
    }

    //ArrayList<Float> list = new ArrayList<>();
    element[] list = new element[num_of_values];
    for (int i=0;i<list.length;i++){
      list[i] = new element();
    }
    //Populate list of floats with random values
    list[0].value = min; list[0].index = 0;
    list[num_of_values-1].value = max; list[num_of_values-1].index = num_of_values-1;
    for (int i =1; i<num_of_values-1; i++){
      Random r = new Random();
      float random = min + r.nextFloat() * (max - min);
      list[i].value = random; list[i].index = i;
    }
    for (int k=0;k<list.length;k++){
      System.out.println(list[k].value);
    }
    System.out.println();
    //Recursively sort
    quicksort.sort(list,0,num_of_values-1);
    for (int k=0;k<list.length;k++){
      System.out.println(list[k].value);
    }

  }
}
