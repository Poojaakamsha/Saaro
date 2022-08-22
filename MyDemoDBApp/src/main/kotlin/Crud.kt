import java.sql.DriverManager

data class User(val id: Int ,val name: String, val age: Int, val email : String, val phone : Int, val city : String , val state : String, val country : String, val pincode: Int)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb1"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "sania@1434")
    println(connection.isValid(0))

    // INSERT QUERY.......

//    val res = connection.createStatement().executeUpdate("insert into users(id,name,age,email,phone,city,state,country,pincode) values (4,'scott',60,'scott@gmail.com',9031500,'surat','gujarat','india',222053)")
//    if (res>0){
//        println("Successfully records into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // UPDATE QUERY.....

//    val update = connection.createStatement().executeUpdate("update users set age=22 where name='scott'")
//    if (update>0){
//       println("Successfully Updated into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // DELETE QUERY....

//    val delete = connection.createStatement().executeUpdate("delete from users where id=4")
//    if (delete > 0) {
//        println("Successfully Deleted from users db !!!")
//    } else {
//        println("not successful")
//    }

    //READ-ONLY....

    val query = connection.prepareStatement("select * from users")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val id = result.getInt("id")
        val name = result.getString("name")
        val age = result.getInt("age")
        val email = result.getString("email")
        val phone = result.getInt("phone")
        val city = result.getString("city")
        val state = result.getString("state")
        val country = result.getString("country")
        val pincode = result.getInt("pincode")
        users.add(User(id, name, age, email,phone, city,state, country, pincode))
    }

    println(users)

}
