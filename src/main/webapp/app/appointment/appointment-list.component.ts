import {Component, inject, OnDestroy, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavigationEnd, Router, RouterLink} from '@angular/router';
import {Subscription} from 'rxjs';
import {ErrorHandler} from 'app/common/error-handler.injectable';
import {AppointmentService} from 'app/appointment/appointment.service';
import {AppointmentResponseDTO} from 'app/appointment/appointment.model';


@Component({
  selector: 'app-appointment-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './appointment-list.component.html'
})
export class AppointmentListComponent implements OnInit, OnDestroy {

  appointmentService = inject(AppointmentService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  appointments: AppointmentResponseDTO[] | null | undefined;
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@appointment.delete.success:Appointment was removed successfully.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.loadData();
    this.navigationSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.loadData();
      }
    });
  }

  ngOnDestroy() {
    this.navigationSubscription!.unsubscribe();
  }

  loadData() {
    this.appointmentService.getAllAppointments()
      .subscribe({
        next: (data) => this.appointments = data.content,
        error: (error) => this.errorHandler.handleServerError(error.error)
      });
  }

  confirmDelete(id: number) {
    if (confirm(this.getMessage('confirm'))) {
      this.appointmentService.deleteAppointment(id)
        .subscribe({
          next: () => this.router.navigate(['/appointments'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    }
  }

}
