import java.sql.DriverManager

// MODEL CLASS......

data class User(val id: Int ,val ticket_number: Int, val passenger_id: Int, val train_id : Int, val ticket_price : Int )

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/newdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "sania@1434")
    println(connection.isValid(0))

    // INSERT QUERY.....

//    val res = connection.createStatement().executeUpdate("insert into train(id , ticket_number, passenger_id ,train_id, ticket_price) values (101,24,21,10,50)")
//    if (res>0){
//        println("Successfully records into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // UPDATE QUERY......

//    val update = connection.createStatement().executeUpdate("update ticket set ticket_number=142 where ticket_number=143")
//    if (update>0){
//        println("Successfully Updated into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // DELETE QUERY......

//    val delete = connection.createStatement().executeUpdate("delete from ticket where id=4")
//    if (delete > 0) {
//        println("Successfully Deleted from users db !!!")
//    } else {
//        println("not successful")
//    }

    //SELECT QUERY-READ.......

    val query = connection.prepareStatement("select * from ticket")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val id = result.getInt("id")
        val ticket_number = result.getInt("ticket_number")
        val passenger_id= result.getInt("passenger_id")
        val train_id = result.getInt("train_id")
        val ticket_price = result.getInt("ticket_price")

        users.add(User(id,ticket_number,passenger_id,train_id,ticket_price))
    }

    println(users)
}