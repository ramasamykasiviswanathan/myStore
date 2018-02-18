import { NgModule } from '@angular/core';
import { CovalentStepsModule } from '@covalent/core/steps';
import { CovalentExpansionPanelModule } from '@covalent/core/expansion-panel';
import { CovalentFileModule } from '@covalent/core/file';
import { CovalentChipsModule } from '@covalent/core/chips';
import { CovalentLoadingModule } from '@covalent/core/loading';
import { CovalentDialogsModule } from '@covalent/core/dialogs';
import { CovalentDataTableModule } from '@covalent/core/data-table';
import { CovalentVirtualScrollModule } from '@covalent/core/virtual-scroll';
import { CovalentJsonFormatterModule } from '@covalent/core/json-formatter';
import { CovalentPagingModule } from '@covalent/core/paging';
import { CovalentNotificationsModule } from '@covalent/core/notifications';
import { CovalentMessageModule } from '@covalent/core/message';
import { CovalentSearchModule } from '@covalent/core/search';
import { CovalentMediaModule } from '@covalent/core/media';
import { CovalentCommonModule } from '@covalent/core/common';
import { CovalentLayoutModule } from '@covalent/core/layout';
import { CovalentMenuModule } from '@covalent/core/menu';

// other imports
@NgModule({
  imports: [
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentExpansionPanelModule,
    CovalentStepsModule,
    CovalentLoadingModule,
    CovalentDialogsModule,
    CovalentSearchModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentMenuModule,
    CovalentDataTableModule,
    CovalentMessageModule,
    CovalentFileModule,
    CovalentChipsModule,
    CovalentVirtualScrollModule,
    CovalentJsonFormatterModule
  ],
  exports: [
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentExpansionPanelModule,
    CovalentStepsModule,
    CovalentLoadingModule,
    CovalentDialogsModule,
    CovalentSearchModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentMenuModule,
    CovalentDataTableModule,
    CovalentMessageModule,
    CovalentFileModule,
    CovalentChipsModule,
    CovalentVirtualScrollModule,
    CovalentJsonFormatterModule
  ]
})
export class CovalentModule {}
