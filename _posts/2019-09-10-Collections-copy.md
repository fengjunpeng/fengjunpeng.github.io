


ArrayList<Integer> arrayList = new ArrayList<>(10);
arrayList.add(1);
arrayList.add(2);
arrayList.add(3);
ArrayList<? super Integer> arrayList1 = new ArrayList<>(arrayList);
Collections.copy(arrayList1, arrayList);
System.out.println(arrayList1.get(0));
arrayList.set(0,2);
System.out.println(arrayList1.get(0));