package LabSession6.Part2.DataOnly;

import java.io.Serializable;
import LabSession6.Part2.Components.PetriNet;
import LabSession6.Part2.Components.PetriNetWindow;

public class SubPetri implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubPetri clone() throws CloneNotSupportedException {
		return (SubPetri) super.clone();
	}

	public PetriNet Petri;

	public SubPetri(PetriNet Petri) {
		this.Petri = Petri;
	}

	private Thread t1;

	public void StartSubPetri() {
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				PetriNetWindow SubPetriFrame = new PetriNetWindow(true);
				SubPetriFrame.petriNet = Petri;
				SubPetriFrame.setVisible(true);
			}
		});
		t1.start();
	}

	@SuppressWarnings({ "removal" })
	public void StopSubPetri() {
		if (t1 != null) {
			t1.stop();
		}
		//SubPetriFrame.setVisible(false);
	}

	public String toString() {
		return Petri.PetriNetName + "-" + Petri.PetriState.toString();
	}
};
