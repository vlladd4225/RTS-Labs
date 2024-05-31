package LabSession6.Part2.OETPN;

import LabSession6.Part2.Components.PetriNetWindow;
import LabSession6.Part2.Enumerations.LogicConnector;
import LabSession6.Part2.Enumerations.PetriObjectType;
import LabSession6.Part2.Enumerations.TransitionCondition;
import LabSession6.Part2.Enumerations.TransitionOperation;
import LabSession6.Part2.PetriDataPackage.Guard;
import LabSession6.Part2.PetriDataPackage.GuardActivation;
import LabSession6.Part2.PetriDataPackage.GuardCondition;
import LabSession6.Part2.PetriDataPackage.PetriData;
import LabSession6.Part2.PetriDataPackage.Place;
import LabSession6.Part2.PetriDataPackage.Transition;
import LabSession6.Part2.Utilities.Functions;

public class test {
	public static void main(String[] args) {

		PetriData pn = new PetriData();
		pn.Name = "PN2";
		pn.Port = 1090;
		pn.Delay = 3000;

		// ------------------------------------------------------------------------

		Place p1 = new Place("constValue", PetriObjectType.DataFloat, 1.0f);
		pn.Places.add(p1);
		pn.Places.add(new Place("p21", PetriObjectType.DataFloat, 1.0f));
		pn.Places.add(new Place("p22", PetriObjectType.DataFloat, null));
		pn.Places.add(new Place("p23", PetriObjectType.DataSubPetri, null));
		pn.Places.add(new Place("p24", PetriObjectType.DataSubPetri, null));
		pn.Places.add(new Place("p25", PetriObjectType.DataFloat, null));

		// T21 ------------------------------------------------
		Transition t21 = new Transition();

		t21.Name = "t21";
		t21.InputPlaces.add("p21");
		t21.InputPlaces.add("p22");

		Guard grdT21 = new Guard();

		grdT21.GuardCondition = new GuardCondition("p21", TransitionCondition.NotNull);
		grdT21.GuardCondition.SetNextCondition(LogicConnector.AND,
				new GuardCondition("p22", TransitionCondition.NotNull));

		grdT21.GuardActivations.add(new GuardActivation("p22", TransitionOperation.Move, "p23"));

		t21.Guards.add(grdT21);
		t21.Delay = 0;
		pn.Transitions.add(t21);

		// T22 ------------------------------------------------
		Transition t22 = new Transition();
		t22.Name = "t22";
		t22.InputPlaces.add("p23");
		t22.InputPlaces.add("constValue");

		Guard grdT22 = new Guard();
		grdT22.GuardCondition = new GuardCondition("p23", TransitionCondition.NotNull);

		grdT22.GuardActivations.add(new GuardActivation("p23", TransitionOperation.ActivateSubPetri, ""));
		grdT22.GuardActivations.add(new GuardActivation("constValue", TransitionOperation.Copy, "constValue"));
		grdT22.GuardActivations.add(new GuardActivation("constValue", TransitionOperation.Move, "p25"));

		t22.Guards.add(grdT22);
		t22.Delay = 0;
		pn.Transitions.add(t22);

		// T23 ------------------------------------------------
		Transition t23 = new Transition();
		t23.Name = "t23";
		t23.InputPlaces.add("p25");

		Guard grdT23 = new Guard();
		grdT23.GuardCondition = new GuardCondition("p25", TransitionCondition.NotNull);

		grdT23.GuardActivations.add(new GuardActivation("p25", TransitionOperation.Move, "p21"));

		t23.Guards.add(grdT23);
		t23.Delay = 0;
		pn.Transitions.add(t23);

		System.out.println("Exp2 started \n ------------------------------");
		Functions fn = new Functions();
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = fn.PetriDataToPetriNet(pn);
		frame.setVisible(true);
	}
}
