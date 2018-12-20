package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public interface INode {
    public int getPositionByName(String first, String last);
    public int getPositionByPID(int PID);
    public Patient addLast(Patient patient);
    public Patient addInPosition(Patient patient, int position);
    public boolean removePatient(int PID);
    public Patient addFirst(Patient patient);
    public boolean removeLastPatients(int range);
    public Patient getPatient(int PID);
}
