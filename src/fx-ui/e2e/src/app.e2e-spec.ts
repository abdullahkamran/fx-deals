'use strict'; // necessary for es6 output in node

import { browser, element, by, ElementFinder } from 'protractor';

describe('fx-deals app', () => {

  beforeAll(() => browser.get(''));

  describe('Initial page', () => {

    it('has title FxDeals', async () => {
      expect(await browser.getTitle()).toEqual('FxDeals');
    });

    it('has page heading Fx Deals', () => {
      const topBarHeading = element.all((by.css('app-top-bar h1')));
      expect(topBarHeading.getText()).toEqual('Fx Deals');
    });

    it('has search component stamped in dom', () => {
      let component = element.all((by.css('fx-deal-search')));
      expect(component).toBeTruthy();
    });

    it('has search component stamped in dom', () => {
      let component = element.all((by.css('fx-deal-list')));
      expect(component).toBeTruthy();
    });

    it('has create deal button stamped in dom', () => {
      let component = element.all((by.css('button')));
      expect(component.getText()).toEqual('Create Fx Deal');
      expect(component).toBeTruthy();
    });

    it('has dialog closed initially', () => {
      let component = element.all((by.css('cdk-overlay-backdrop-showing')));
      expect(component).toBeFalsy();
    });

    it('opens dialog when create button is clicked', (done) => {
      let component = element.all((by.css('button')));
      component.click();
      setTimeout(() => {
          expect(component).toBeTruthy();
          done();
      }, 0);
    });
  });
});
