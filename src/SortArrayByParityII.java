
public class SortArrayByParityII {
	public static int[] sortArrayByParityII(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		int idx = 0;
		for (int a : arr) 
			if (a % 2 == 0)
			{
				res[idx] = a;
				idx += 2;
			}
		idx = 1;
		for (int a : arr)
			if (a % 2 != 0)
			{
				res[idx] = a;
				idx += 2;
			}
		return res;
	}
	public static void main(String args[]) {
		int arr[] = {4,2,5,7};
		int[] res = sortArrayByParityII(arr);
		for (int r : res) System.out.print(r + " ");
	} 
}
