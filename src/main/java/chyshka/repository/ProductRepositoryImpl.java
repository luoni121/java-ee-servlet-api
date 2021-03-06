package chyshka.repository;

import chyshka.domain.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static final String FIND_BY_ID_PRODUCT_QUERY_MESSAGE = "SELECT p FROM products p WHERE p.id=:id";
    private static final String FIND_ALL_PRODUCT_QUERY_MESSAGE = "SELECT p FROM products p";

    private EntityManager entityManager;

    public ProductRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("chyshka")
                .createEntityManager();
    }

    @Override
    public Product save(Product entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Product findById(String id) {
        this.entityManager.getTransaction().begin();

        Product product = this.entityManager
                .createQuery(FIND_BY_ID_PRODUCT_QUERY_MESSAGE, Product.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        this.entityManager.getTransaction().begin();

        List<Product> products = this.entityManager
                .createQuery(FIND_ALL_PRODUCT_QUERY_MESSAGE, Product.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return products;
    }
}
