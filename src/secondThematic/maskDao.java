package secondThematic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class maskDao {
	private Session session;

	public maskDao(Session session) {
		this.session = session;
	}

	public maskDao() {
	}

	public void download() throws IOException {
		URL url = new URL("https://data.nhi.gov.tw/resource/mask/maskdata.csv");
		String name = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
		;
		BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream("/Users/apple/eclipse-workspace/secondThematic/maskdata.csv"));
		int read = 0;
		while ((read = inputStream.read()) != -1) {
			out.write(read);
		}
		inputStream.close();
		out.flush();
		out.close();
	}

	@SuppressWarnings("resource")
	public void readcsv() throws IOException {
		download();
		File file = new File("/Users/apple/eclipse-workspace/secondThematic/maskdata.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		StringBuilder stbu = new StringBuilder();

		while ((line = br.readLine()) != null) {

			stbu.append(line);
			stbu.append(",");
		}

		String[] list = stbu.toString().split(",");
		for (int i = 7; i < list.length; i += 7) {
			masks maskbean = new masks();
			maskbean.setHospitalId(list[i]);
			maskbean.setHospitalName(list[i + 1]);
			maskbean.setHopsitalAddress(list[i + 2]);
			maskbean.setHopsitalPhone(list[i + 3]);
			maskbean.setMaskOfAdult(Integer.parseInt(list[i + 4]));
			maskbean.setMaskOfchild(Integer.parseInt(list[i + 5]));
			session.save(maskbean);

		}

		br.close();

	}

	public void update() {
		Query<masks> query = session.createQuery("update masks set MaskOfAdult=:count", masks.class);
	}

	public List<masks> queryAll() {
		Query<masks> query = session.createQuery("from masks", masks.class);
		List<masks> list = query.list();
		return list;
	}

	
	public List<masks> querycity(String city) {
		Query<masks> query = session.createQuery("from masks where hopsitalAddress like :city order by MaskOfAdult desc", masks.class);
		query.setParameter("city", "%"+city + "%");
		List<masks> list = query.list();
		return list;
	}

	public masks queryData(int id) {
		masks myBean = session.get(masks.class, id);
		return myBean;

	}
	public void orderMasks(int id) {
		masks mybean = session.get(masks.class,id);
		int mask = mybean.getMaskOfAdult()-2;
		mybean.setMaskOfAdult(mask);
		session.save(mybean);
	}
	public void cancelMasks(int id) {
		masks mybean = session.get(masks.class,id);
		int mask = mybean.getMaskOfAdult()+2;
		mybean.setMaskOfAdult(mask);
		session.save(mybean);
	}
}
