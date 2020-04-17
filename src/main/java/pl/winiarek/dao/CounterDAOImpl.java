
package pl.winiarek.dao;

import java.util.List;

import pl.winiarek.entity.Counter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CounterDAOImpl implements CounterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public Counter getCounter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override

    public List<Counter> getElectricityCounter() {
        Session currentSession = sessionFactory.getCurrentSession();

		/*Query<Counter> theQuery = currentSession.createQuery(
				"FROM Counter Where counterMedium='Elektryczny' GROUP BY counterSerialNumber ORDER BY counterAddress",
				Counter.class);*/
        Query<Counter> theQuery = currentSession.createQuery(
                "select t from Counter t\n" +
                        "where counterMedium='Elektryczny' and  not exists (\n" +
                        "  select 1 from Counter\n" +
                        "  where counterSerialNumber = t.counterSerialNumber and counterLocation = t.counterLocation and counterDate > t.counterDate\n" +
                        ")",
                Counter.class);
        List<Counter> counters = theQuery.getResultList();
		return counters;
    }

    @Override

    public List<Counter> getWaterCounter() {
        Session currentSession = sessionFactory.getCurrentSession();

		/*Query<Counter> theQuery = currentSession.createQuery(
				"FROM Counter Where counterMedium='Wodomierz' GROUP BY counterSerialNumber ORDER BY counterAddress",
				Counter.class);*/
        Query<Counter> theQuery = currentSession.createQuery(
                "select t from Counter t\n" +
                        "where counterMedium='Wodomierz' and  not exists (\n" +
                        "  select 1 from Counter\n" +
                        "  where  counterSerialNumber = t.counterSerialNumber and counterLocation = t.counterLocation and counterDate > t.counterDate\n" +
                        ")",
                Counter.class);
        List<Counter> counters = theQuery.getResultList();

        return counters;
    }

    @Override

    public List<Counter> getCoolingCounter() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Counter> theQuery = currentSession.createQuery(
                "select t from Counter t\n" +
                        "where counterMedium='Chłód' and  not exists (\n" +
                        "  select 1 from Counter\n" +
                        "  where counterSerialNumber = t.counterSerialNumber and counterLocation = t.counterLocation and counterDate > t.counterDate\n" +
                        ")",
                Counter.class);
        List<Counter> counters = theQuery.getResultList();

        return counters;
    }

    @Override

    public List<Counter> getHeatingCounter() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Counter> theQuery = currentSession.createQuery(
                "select t from Counter t\n" +
                        "where counterMedium='Ciepłomierz' and  not exists (\n" +
                        "  select 1 from Counter\n" +
                        "  where counterSerialNumber = t.counterSerialNumber and counterLocation = t.counterLocation and counterDate > t.counterDate\n" +
                        ")",
                Counter.class);
        List<Counter> counters = theQuery.getResultList();

        return counters;
    }

    @Override
    public List<Counter> getGasCounter() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Counter> theQuery = currentSession.createQuery(
                "select t from Counter t\n" +
                        "where counterMedium='Gaz' and  not exists (\n" +
                        "  select 1 from Counter\n" +
                        "  where counterSerialNumber = t.counterSerialNumber and counterLocation = t.counterLocation and counterDate > t.counterDate\n" +
                        ")",
                Counter.class);
        List<Counter> counters = theQuery.getResultList();

        return counters;
    }

    @Override
    public List<Counter> getCounterDetail(int theSerialNumber) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Counter> theQuery = currentSession
                .createQuery("FROM Counter Where counterSerialNumber='" + theSerialNumber + "' order by counterValue DESC", Counter.class);

        List<Counter> counters = theQuery.getResultList();
        return counters;
    }

}
