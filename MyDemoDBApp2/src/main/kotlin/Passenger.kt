import java.sql.DriverManager

// MODEL CLASS......

data class User(val passenger_id: Int , val passenger_name: String, val passenger_age : Int, val gender : String, val phone : String )

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/newdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "sania@1434")
    println(connection.isValid(0))

    // INSERT QUERY.....

//    val res = connection.createStatement().executeUpdate("insert into passengers(passenger_id , passenger_name, passenger_age ,gender, phone) values (04,'san',21,'F','9008331500')")
//    if (res>0){
//        println("Successfully records into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // UPDATE QUERY......

//    val update = connection.createStatement().executeUpdate("update passengers set passenger_name='ryan' where passenger_id=4")
//    if (update>0){
//        println("Successfully Updated into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // DELETE QUERY......

//    val delete = connection.createStatement().executeUpdate("delete from passengers where passenger_id=4")
//    if (delete > 0) {
//        println("Successfully Deleted from users db !!!")
//    } else {
//        println("not successful")
//    }

    //SELECT QUERY-READ.......

    val query = connection.prepareStatement("select * from passengers")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {

        val passenger_id = result.getInt("passenger_id")
        val passenger_name = result.getString("passenger_name")
        val passenger_age = result.getInt("passenger_age")
        val gender = result.getString("gender")
        val phone = result.getString("phone")

        users.add(User(passenger_id,passenger_name,passenger_age,gender,phone))
    }

    println(users)
}