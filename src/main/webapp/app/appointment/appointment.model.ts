export class AppointmentDTO {

  constructor(data:Partial<AppointmentDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  userId?: number|null;
  carId?: number|null;
  appointmentDateTime?: string|null;
  bookingStatus?: string|null;
  notes?: string|null;
  serviceType?: string|null;

}
