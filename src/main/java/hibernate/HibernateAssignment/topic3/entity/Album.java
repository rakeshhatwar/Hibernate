package hibernate.HibernateAssignment.topic3.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name="Album")
public class Album {

	@Id
	@GeneratedValue
	private int albumid;
	
	@Column(name="aname")
	private String aname;
	
	@ElementCollection
	@MapKeyColumn(name = "event")
    @Column(name = "photoName")
    @CollectionTable(name = "event_photos")
	private Map<String,String> photos;

	public Album() {
		
	}
	
	public Album(String aname, Map<String,String> photos) {
		
		this.aname = aname;
		this.photos = photos;
	}
	
	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Map<String, String> getPhotos() {
		return photos;
	}

	public void setPhotos(Map<String, String> photos) {
		this.photos = photos;
	}
}
