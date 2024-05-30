import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { AppointmentDTO } from 'app/appointment/appointment.model';


@Injectable({
  providedIn: 'root',
})
export class AppointmentService {

  http = inject(HttpClient);
  resourcePath = environment.apiPath + '/api/appointments';

  getAllAppointments() {
    return this.http.get<AppointmentDTO[]>(this.resourcePath);
  }

  getAppointment(id: number) {
    return this.http.get<AppointmentDTO>(this.resourcePath + '/' + id);
  }

  createAppointment(appointmentDTO: AppointmentDTO) {
    return this.http.post<number>(this.resourcePath, appointmentDTO);
  }

  updateAppointment(id: number, appointmentDTO: AppointmentDTO) {
    return this.http.put<number>(this.resourcePath + '/' + id, appointmentDTO);
  }

  deleteAppointment(id: number) {
    return this.http.delete(this.resourcePath + '/' + id);
  }

}
