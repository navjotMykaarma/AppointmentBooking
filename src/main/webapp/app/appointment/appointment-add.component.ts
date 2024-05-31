import {Component, inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {InputRowComponent} from 'app/common/input-row/input-row.component';
import {AppointmentService} from 'app/appointment/appointment.service';
import {AppointmentRequestDTO} from 'app/appointment/appointment.model';
import {ErrorHandler} from 'app/common/error-handler.injectable';
import {validOffsetDateTime} from 'app/common/utils';


@Component({
  selector: 'app-appointment-add',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './appointment-add.component.html'
})
export class AppointmentAddComponent {

  appointmentService = inject(AppointmentService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  addForm = new FormGroup({
    carId: new FormControl(null),
    appointmentDateTime: new FormControl(null, [Validators.required, validOffsetDateTime]),
    notes: new FormControl(null),
    carServiceType: new FormControl(null, [Validators.required])
  }, {updateOn: 'submit'});

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@appointment.create.success:Appointment was created successfully.`,
      APPOINTMENT_USER_ID_UNIQUE: $localize`:@@Exists.appointment.userId:This User Id is already taken.`,
      APPOINTMENT_APPOINTMENT_DATE_TIME_UNIQUE: $localize`:@@Exists.appointment.appointmentDateTime:This Appointment Date Time is already taken.`
    };
    return messages[key];
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new AppointmentRequestDTO(this.addForm.value);
    this.appointmentService.createAppointment(data)
      .subscribe({
        next: () => this.router.navigate(['/appointments'], {
          state: {
            msgSuccess: this.getMessage('created')
          }
        }),
        error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
      });
  }

}
