class insertSort {
	
	public static void sort(int a[]) {
		compare = null;

		for (int i = 0; i < a.length; i++) {
			j = i - 1;
			int compare = a[j];
			while (j > 0 && a[j] < compare) {
				a[j + 1] = a[j];
				j = j - 1;
			}
		}
		a[j] = compare;
	}

	public static void main(String[] args) {
		return;
	}

}