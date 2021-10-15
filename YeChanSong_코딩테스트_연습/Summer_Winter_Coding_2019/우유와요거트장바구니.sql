SELECT distinct c.cart_id
from cart_products c
where c.cart_id in (select p.cart_id
                    from cart_products p
                    where p.name="Yogurt") and
                    c.cart_id in (select p.cart_id
                    from cart_products p
                    where p.name="Milk") and
                    c.name in ("Yogurt", "Milk")
order by c.cart_id;