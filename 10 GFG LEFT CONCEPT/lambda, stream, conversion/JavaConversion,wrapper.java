// String to .....
String s = "200";
int i = Integer.parseInt(s); Long.parseLong(str); FLoat.parseFloat("23.8"); Double.parseDouble("23.6"); 

Integer i = Integer.valueOf(s); Integer, Long, Float , Double, 

// ..... to String
int i = 100;
String s = String.valueOf(i); // use everywhere

String s = Integer.toString(); Integer, Long, Float , Double, 

String s = String.format("%d", i);
String s = Character.toString(c); sb.toString()

// String to character Array
char[] ch = str.toCharArray();
// String to Object
Object obj = s;

// char to integer
char ch = 'a';
int a = c; // Character.getNumericValue(c); Integer.parseInt(String.valueOf())
char c1 = (char)a;

// BINARY TO DECIMAL
String bs = "1010";
int dec = Integer.parseInt(bs, 2); // Integer.parseInt(bs, 16); // Integer.parseInt(bs, 8);
Integer.toBinaryString(10); // DECIMAL TO BINARY // Integer.toHexString(10); // Integer.toOctalString(10);

// STRING TO DATE
String sDate1="31/12/1998";  // "dd-MMM-yyyy"  // MM dd, yyyy // E, MMM dd yyyy // E, MMM dd yyyy HH:mm:ss
Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  // dd-MMM-yyyy HH:mm:ss
System.out.println(sDate1+"\t"+date1);  // 31/12/1998	Thu Dec 31 00:00:00 IST 1998

// DATE TO STRING
Date date = Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
String strDate = dateFormat.format(date);  
System.out.println("Converted String: " + strDate);  

// WRAPPER CLASS

                 

