import java.sql.DriverManager

//model class

data class User(val id: Int ,val name: String)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/sampleid"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "sania@1434")
    println(connection.isValid(0))

    //insert query

//    val res = connection.createStatement().executeUpdate("insert into users(id,name) values (11,'idiot')")
//    if (res > 0) {
//        println("Successfully records into users db !!!")
//    } else {
//        println("not successful")
//    }
//    //update query -Update
//    val update_res = connection.createStatement().executeUpdate("update users set name = 'mad' where id = 10")
//    if(update_res > 0) {
//        println("successfully updated!!!")
//    } else{
//        println("update not successfull")
//    }
//    //delete Query
//    val delete_res = connection.createStatement().executeUpdate("delete from users  where id = 3")
//    if (delete_res > 0) {
//        println("Successfully deleted!!!")
//    } else {
//        println("not successful")
//    }
    //select Query - Read
    val query = connection.prepareStatement("select * from users")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val id = result.getInt("id")
        val name = result.getString("name")
        users.add(User(id, name))
    }

    println(users)
}