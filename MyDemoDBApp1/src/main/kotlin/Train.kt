import java.sql.DriverManager

// MODEL CLASS......

data class User(val train_id: Int ,val train_no: String, val train_name: String, val source : String, val destination : String, val start_date_time : String, val arrival_time : String )

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/newdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "sania@1434")
    println(connection.isValid(0))

    // INSERT QUERY.....

//    val res = connection.createStatement().executeUpdate("insert into passengers(passenger_id , passenger_name, passenger_age ,gender, phone) values (04,'san',21,'F','9008331500')")
//    if (res>0){
//        println("Successfully  inserted records into users db !!!")
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

    val query = connection.prepareStatement("select * from train")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val train_id = result.getInt("train_id")
        val train_no = result.getString("train_no")
        val train_name = result.getString("train_name")
        val source = result.getString("source")
        val destination = result.getString("destination")
        val start_date_time = result.getString("start_date_time")
        val arrival_time = result.getString("arrival_time")

        users.add(User(train_id,train_no,train_name,source,destination,start_date_time,arrival_time))
    }

    println(users)
}