import { CommonModule } from '@angular/common';
import { Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-carrusel',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carrusel.component.html',
  styleUrl: './carrusel.component.css'
})
export class CarruselComponent implements OnInit, OnDestroy {

  currentIndex: number = 0;
  intervalId: any; // Variable para almacenar el ID del intervalo

  images = [
    { src: 'banner.jpg?text=Imagen+1', alt: 'Imagen 1' },
    { src: 'banner2.jpg?text=Imagen+2', alt: 'Imagen 2' },
    { src: 'banner3.jpg?text=Imagen+3', alt: 'Imagen 3' }
  ];

  constructor() { }


  ngOnInit(): void {
    // Iniciar el intervalo para cambiar la imagen cada 3 segundos (3000 ms)
    this.startAutoSlide();
  }

  ngOnDestroy(): void {
    // Limpiar el intervalo cuando el componente se destruya
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }

  startAutoSlide(): void {
    // Establecer un intervalo de 3 segundos para cambiar de imagen
    this.intervalId = setInterval(() => {
      this.next();
    }, 3000); // 3000 ms = 3 segundos
  }

  getTransform(): string {
    return `translateX(-${this.currentIndex * 100}%)`;
  }

  next(): void {
    this.currentIndex = (this.currentIndex + 1) % this.images.length;
  }

  previous(): void {
    this.currentIndex = (this.currentIndex - 1 + this.images.length) % this.images.length;
  }
}
