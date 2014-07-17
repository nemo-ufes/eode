package br.ufes.inf.nemo.odercp.rcpapp.standardProcess.cpd;

import java.util.Set;



public class GeneralStandardProcess extends StandardProcess{
    
    private Set<SpecificStandardProcess> specificStandardProcesses;

		/** Constructor. */
		public GeneralStandardProcess() {
			super();
		}

		/** Getter for specificStandardProcesses. */
		public Set<SpecificStandardProcess> getSpecificStandardProcesses() {
			return specificStandardProcesses;
		}

		/** Setter for specificStandardProcesses. */
		public void setSpecificStandardProcesses(Set<SpecificStandardProcess> specificStandardProcesses) {
			this.specificStandardProcesses = specificStandardProcesses;
		}
    
       
}
