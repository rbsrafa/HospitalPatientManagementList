/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author rbsrafa
 */
public interface INode {
    public int getPositionByName(String first, String last);
    public int getPositionByPID(int PID);
    public Patient addLast(Patient patient);
    public Patient addInPosition(Patient patient, int position);
    public boolean removePatient(int PID);
    public Patient addFirst(Patient patient);
    public boolean removeLastPatients(int range);
    public Patient updatePatientInfo(int PID);
}
