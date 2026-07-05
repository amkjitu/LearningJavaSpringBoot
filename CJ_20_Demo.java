/*
record: A record is a special kind of class in Java that is used to model immutable data. It was introduced in Java 14 as a preview feature and became a standard feature in Java 16. Records are designed to be a concise way to create classes that primarily hold data, without the need for boilerplate code such as getters, setters, equals(), hashCode(), and toString() methods.
    Notes to remember:
    1. Records are implicitly final, which means they cannot be extended by other classes.
    2. Records automatically generate a constructor that takes all the fields as parameters, and the fields are implicitly final, which means they cannot be modified after the record is created.
    3. Records can implement interfaces, but they cannot extend other classes.
    4. Records can have static methods, static fields, and instance methods, but they cannot have instance fields that are not part of the record's state.
    5. Records can have compact constructors, which allow you to define additional validation or logic for the record's fields.
*/

// class HouseData {
//     private final int houseNo;
//     private final String houseName;

//     public HouseData(int houseNo, String houseName) {
//         this.houseNo = houseNo;
//         this.houseName = houseName;
//     }

//     // getters
//     public int getHouseNo() {
//         return houseNo;
//     }

//     public String getHouseName() {
//         return houseName;
//     }

//     // Override toString(), equals() and hashCode() methods
//     @Override
//     public String toString() {
//         return "HouseData{" +
//                 "houseNo=" + houseNo +
//                 ", houseName='" + houseName + '\'' +
//                 '}';
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null || getClass() != obj.getClass())
//             return false;
//         HouseData that = (HouseData) obj;
//         return houseNo == that.houseNo && houseName.equals(that.houseName);
//     }

//     @Override
//     public int hashCode() {
//         int result = Integer.hashCode(houseNo);
//         result = 31 * result + houseName.hashCode();
//         return result;
//     }
// }

record HouseData(int houseNo, String houseName) {
    // The record automatically generates the constructor, getters, toString(), equals(), and hashCode() methods.
    // instance variables are final and cannot be modified after the record is created.
    // so the staff we did above class is not needed anymore because the record will automatically generate them for us.

    // but we can write a compact canonical constructor if we want to add some validation or logic to the record's fields.
    public HouseData {
        if (houseNo <= 0) {
            throw new IllegalArgumentException("House number must be positive");
        }
        if (houseName == null || houseName.isEmpty()) {
            throw new IllegalArgumentException("House name cannot be null or empty");
        }
    }
}

public class CJ_20_Demo {
    public static void main(String[] args) {
        // Create a record instance
        HouseData house1 = new HouseData(101, "Green Villa");
        HouseData house2 = new HouseData(102, "Blue Cottage");
        HouseData house3 = new HouseData(102, "Blue Cottage");

        // Print the record instances
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);

        // Compare two record instances
        System.out.println("Are the two houses equal? " + house1.equals(house2));
        System.out.println("Are the two houses equal? " + house2.equals(house3));
    }

}
