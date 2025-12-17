package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    // add additional method signatures here

    ShoppingCart addShoppingCartItem(ShoppingCartItem item, User user);

}
