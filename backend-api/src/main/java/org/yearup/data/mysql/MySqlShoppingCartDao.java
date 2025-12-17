package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    private DataSource dataSource;

    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    public ShoppingCart getByUserId(int userId) {
        return new ShoppingCart();
    }

    @Override
    public ShoppingCart addShoppingCartItem(ShoppingCartItem item, User user) {

        String sql = """
                INSERT INTO shopping_cart (user_id, product_id, quantity)
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    quantity = quantity + VALUES(quantity)
                """;

        try (Connection connection = super.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, item.getProductId());
            preparedStatement.setInt(3, item.getQuantity());
            preparedStatement.executeUpdate();

            return getByUserId(user.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
