import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { AppointmentService } from 'app/appointment/appointment.service';
import { AppointmentDTO } from 'app/appointment/appointment.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { updateForm, validOffsetDateTime } from 'app/common/utils';


@Component({
  selector: 'app-appointment-edit',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './appointment-edit.component.html'
})
export class AppointmentEditComponent implements OnInit {

  appointmentService = inject(AppointmentService);
  route = inject(ActivatedRoute);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  currentId?: number;

  editForm = new FormGroup({
    id: new FormControl({ value: null, disabled: true }),
    userId: new FormControl(null, [Validators.required]),
    carId: new FormControl(null),
    appointmentDateTime: new FormControl(null, [Validators.required, validOffsetDateTime]),
    bookingStatus: new FormControl(null, [Validators.required]),
    notes: new FormControl(null),
    serviceType: new FormControl(null, [Validators.required])
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      updated: $localize`:@@appointment.update.success:Appointment was updated successfully.`,
      APPOINTMENT_USER_ID_UNIQUE: $localize`:@@Exists.appointment.userId:This User Id is already taken.`,
      APPOINTMENT_APPOINTMENT_DATE_TIME_UNIQUE: $localize`:@@Exists.appointment.appointmentDateTime:This Appointment Date Time is already taken.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.currentId = +this.route.snapshot.params['id'];
    this.appointmentService.getAppointment(this.currentId!)
        .subscribe({
          next: (data) => updateForm(this.editForm, data),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.editForm.markAllAsTouched();
    if (!this.editForm.valid) {
      return;
    }
    const data = new AppointmentDTO(this.editForm.value);
    this.appointmentService.updateAppointment(this.currentId!, data)
        .subscribe({
          next: () => this.router.navigate(['/appointments'], {
            state: {
              msgSuccess: this.getMessage('updated')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.editForm, this.getMessage)
        });
  }

}
