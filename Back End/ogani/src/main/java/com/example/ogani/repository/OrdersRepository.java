package com.example.ogani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ogani.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = "SELECT * FROM Orders WHERE user_id = :userId ORDER BY date_order DESC", nativeQuery = true)
    List<Orders> getOrdersByUserDESC(@Param("userId") long userId);

    @Query(value = "SELECT * FROM Orders WHERE user_id = :userId ORDER BY date_order ASC", nativeQuery = true)
    List<Orders> getOrdersByUserASC(@Param("userId") long userId);

<<<<<<< HEAD
=======
    // @Query(value = "SELECT * FROM Orders WHERE date_order = :currentDate AND user_id = :userId", nativeQuery = true)
    // Orders getOrderExist(@Param("currentDate") Date currentDate,@Param("userId") long userId);

    // @Query(value = "SELECT COUNT(o) > 0 FROM Orders o WHERE o.date_order = :currentDate AND o.user_id = :userId", nativeQuery = true)
    // boolean existsByDateOrder(@Param("currentDate") Date currentDate, @Param("userId") long userId);

>>>>>>> origin/master
    @Query(value = "SELECT id FROM orders WHERE user_id = :userId AND date_order = TO_DATE(:currentDate, 'DD-MM-YY')", nativeQuery = true)
    long getOrderExist(@Param("currentDate") String currentDate, @Param("userId") long userId);

    @Query(value = "Select * FROM orders WHERE user_id = :userId AND date_order = TO_DATE(:currentDate, 'DD-MM-YY')", nativeQuery = true)
    Orders existsByDateOrder(@Param("currentDate") String currentDate, @Param("userId") long userId);
<<<<<<< HEAD
}
=======
}
// SELECT CASE WHEN COUNT(*) > 0 THEN 'true' ELSE 'false' END AS result
>>>>>>> origin/master
