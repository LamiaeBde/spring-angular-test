package lu.atozdigital.api.Repository;

import lu.atozdigital.api.Model.ArticlesEntity;
import lu.atozdigital.api.Model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrdersEntity,Long> {

}
