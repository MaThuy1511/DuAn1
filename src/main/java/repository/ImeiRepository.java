package repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.DienThoai;
import model.Imei;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;
import viewmodel.ImeiResponse;

public class ImeiRepository {

    // 1. add
    public boolean add(Imei imei) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(imei);
            transaction.commit();
            check = true;
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace(System.out);
        }
        return check;
    }

    // 2. get by imei
    public Imei getByImei(String imeiStr) {
        Imei imei = null;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("""
                                              SELECT i
                                              FROM Imei i
                                              WHERE i.imei = :imeiStr
                                               """);
            query.setParameter("imeiStr", imeiStr);
            imei = (Imei) query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace(System.out);
        } catch (NoResultException e) {
            imei = null;
        }
        return imei;
    }

    // 3. get all with idDienThoai null
    public List<ImeiResponse> getAllNoneDienThoaiImei() {
        List<ImeiResponse> imeis = new ArrayList<>();

        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("""
                                              SELECT new viewmodel.ImeiResponse
                                              (i.id, i.imei)
                                              FROM Imei i
                                              WHERE i.dienThoai IS NULL
                                               """);

            imeis = query.getResultList();
        } catch (HibernateException ex) {
            ex.printStackTrace(System.out);
        }
        return imeis;
    }
    
    // 4. update
    public boolean update(ImeiResponse imeiResponse) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction transaction = session.beginTransaction();

            Imei imei = session.get(Imei.class, imeiResponse.getId());
            DienThoai dt = DienThoaiRepository.getById(imeiResponse.getIdDienThoai());
            imei.setDienThoai(dt);

            session.update(imei);
            transaction.commit();

            check = true;
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    public static void main(String[] args) {
//        List<ImeiResponse> imeiResponses = getAllNoneDienThoaiImei();
//        imeiResponses.forEach(i -> System.out.println(i.toString()));

//        Imei imei = getByImei("111111111122222");
//        System.out.println(imei.getId());
//        Imei imei1 = new Imei();
//        imei1.setImei("111221111122222");
//        System.out.println(add(imei1));
    }
}
