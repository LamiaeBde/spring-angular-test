import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddarticlesComponent } from './addarticles.component';

describe('AddarticlesComponent', () => {
  let component: AddarticlesComponent;
  let fixture: ComponentFixture<AddarticlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddarticlesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddarticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
