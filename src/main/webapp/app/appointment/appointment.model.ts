export class AppointmentDTO {

  id?: number | null;
  userId?: number | null;
  carId?: number | null;
  appointmentDateTime?: string | null;
  bookingStatus?: string | null;
  notes?: string | null;
  serviceType?: string | null;

  constructor(data: Partial<AppointmentDTO>) {
    Object.assign(this, data);
  }

}

export class AppointmentResponseDTO {

  id?: number | null;
  carId?: number | null;
  notes?: string | null;
  appointmentDateTime?: string | null;
  bookingCarServiceStatus?: string | null;
  carServiceType?: string | null;

  constructor(data: Partial<AppointmentResponseDTO>) {
    Object.assign(this, data);
  }
}

export class AppointmentRequestDTO {

  carId?: number | null;
  notes?: string | null;
  appointmentDateTime?: string | null;
  carServiceType?: string | null;

  constructor(data: Partial<AppointmentRequestDTO>) {
    Object.assign(this, data);
  }
}

export class Sort {
  empty?: boolean | null;
  sorted?: boolean | null;
  unsorted?: boolean | null;

  constructor(data: Partial<Sort>) {
    Object.assign(this, data);
  }
}

export class Pageable {
  sort?: Sort | null;
  offset?: number | null;
  pageNumber?: number | null;
  pageSize?: number | null;
  paged?: boolean | null;
  unpaged?: boolean | null;
}

export class Page<T> {
  content?: T[] | null;
  pageable?: Pageable | null;
  sort?: Sort | null;
  first?: boolean | null;
  numberOfElements?: number | null;
  empty?: boolean | null;
}
