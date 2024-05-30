import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AppointmentListComponent } from './appointment/appointment-list.component';
import { AppointmentAddComponent } from './appointment/appointment-add.component';
import { AppointmentEditComponent } from './appointment/appointment-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'appointments',
    component: AppointmentListComponent,
    title: $localize`:@@appointment.list.headline:Appointments`
  },
  {
    path: 'appointments/add',
    component: AppointmentAddComponent,
    title: $localize`:@@appointment.add.headline:Add Appointment`
  },
  {
    path: 'appointments/edit/:id',
    component: AppointmentEditComponent,
    title: $localize`:@@appointment.edit.headline:Edit Appointment`
  },
  {
    path: 'error',
    component: ErrorComponent,
    title: $localize`:@@error.headline:Error`
  },
  {
    path: '**',
    component: ErrorComponent,
    title: $localize`:@@notFound.headline:Page not found`
  }
];
