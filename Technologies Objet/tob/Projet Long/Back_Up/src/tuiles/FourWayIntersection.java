package tuiles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tuile_abstraites.Champs;
import tuile_abstraites.Route;
import tuile_abstraites.TuileAbstraite;
import tuile_abstraites.Ville;
import tuiles_spec.CreateurTuile;
import tuiles_spec.VueTuileAbstraite;

@SuppressWarnings("serial")
public class FourWayIntersection extends VueTuileAbstraite {
	private static final String IMAGE_PATH = "src/resources/Four_Way_Intersection.png";

	public FourWayIntersection(int row, int col) {
		super(IMAGE_PATH, row, col);
	}
	
	private FourWayIntersection() {}
	
	@Override
	public List<TuileAbstraite> construireObjetListe() {
		List<TuileAbstraite> objects = new ArrayList<TuileAbstraite>();
		
		Map<Rotation, List<TuileAbstraite.Position>> temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.NORTH, Arrays.asList(TuileAbstraite.Position.CENTRE));
		objects.add(new Route(temp, new Point(LARGEUR_TUILE / 2, HAUTEUR_TUILE / 4)));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.EAST, Arrays.asList(TuileAbstraite.Position.CENTRE));
		objects.add(new Route(temp, new Point(LARGEUR_TUILE * 3 / 4, HAUTEUR_TUILE / 2)));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.SOUTH, Arrays.asList(TuileAbstraite.Position.CENTRE));
		objects.add(new Route(temp, new Point(LARGEUR_TUILE / 2, HAUTEUR_TUILE * 3 / 4)));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.WEST, Arrays.asList(TuileAbstraite.Position.CENTRE));
		objects.add(new Route(temp, new Point(LARGEUR_TUILE / 4, HAUTEUR_TUILE / 2)));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.NORTH, Arrays.asList(TuileAbstraite.Position.DROITE));
		temp.put(Rotation.EAST, Arrays.asList(TuileAbstraite.Position.GAUCHE));
		objects.add(new Champs(temp, new Point(LARGEUR_TUILE * 3 / 4, HAUTEUR_TUILE / 4), new ArrayList<Ville>()));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.EAST, Arrays.asList(TuileAbstraite.Position.DROITE));
		temp.put(Rotation.SOUTH, Arrays.asList(TuileAbstraite.Position.GAUCHE));
		objects.add(new Champs(temp, new Point(LARGEUR_TUILE * 3 / 4, HAUTEUR_TUILE * 3 / 4), new ArrayList<Ville>()));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.SOUTH, Arrays.asList(TuileAbstraite.Position.DROITE));
		temp.put(Rotation.WEST, Arrays.asList(TuileAbstraite.Position.GAUCHE));
		objects.add(new Champs(temp, new Point(LARGEUR_TUILE / 4, HAUTEUR_TUILE * 3 / 4), new ArrayList<Ville>()));
		
		temp = new HashMap<Rotation, List<TuileAbstraite.Position>>();
		temp.put(Rotation.WEST, Arrays.asList(TuileAbstraite.Position.DROITE));
		temp.put(Rotation.NORTH, Arrays.asList(TuileAbstraite.Position.GAUCHE));
		objects.add(new Champs(temp, new Point(LARGEUR_TUILE / 4, HAUTEUR_TUILE / 4), new ArrayList<Ville>()));
		
		return objects;	
	}

	@Override
	public VueTuileAbstraite construireTuile(int row, int col) {
		return new FourWayIntersection(row, col);
	}
	
	public static CreateurTuile getConstruction() {
		return new CreateurTuile(new FourWayIntersection());
	}
	

	
	
	
	

}
