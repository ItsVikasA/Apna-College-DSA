// DOM Content Loaded
document.addEventListener('DOMContentLoaded', function() {
    // Mobile Navigation Toggle
    const hamburger = document.querySelector('.hamburger');
    const navMenu = document.querySelector('.nav-menu');

    hamburger.addEventListener('click', function() {
        hamburger.classList.toggle('active');
        navMenu.classList.toggle('active');
    });

    // Close mobile menu when clicking on a link
    document.querySelectorAll('.nav-link').forEach(link => {
        link.addEventListener('click', function() {
            hamburger.classList.remove('active');
            navMenu.classList.remove('active');
        });
    });

    // Smooth scrolling for navigation links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // Navbar scroll effect
    window.addEventListener('scroll', function() {
        const navbar = document.querySelector('.navbar');
        if (window.scrollY > 100) {
            navbar.style.background = 'rgba(15, 15, 15, 0.98)';
            navbar.style.backdropFilter = 'blur(20px)';
        } else {
            navbar.style.background = 'rgba(15, 15, 15, 0.95)';
            navbar.style.backdropFilter = 'blur(20px)';
        }
    });

    // Intersection Observer for animations
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.animation = 'fadeInUp 0.6s ease-out forwards';
            }
        });
    }, observerOptions);

    // Observe elements for animation
    document.querySelectorAll('.algorithm-card, .pattern-item, .project-card, .stat-item').forEach(el => {
        observer.observe(el);
    });

    // Counter animation for stats
    function animateCounter(element, target, duration = 2000) {
        let start = 0;
        const increment = target / (duration / 16);
        
        function updateCounter() {
            start += increment;
            if (start < target) {
                element.textContent = Math.floor(start) + '+';
                requestAnimationFrame(updateCounter);
            } else {
                element.textContent = target + '+';
            }
        }
        updateCounter();
    }

    // Stats counter animation
    const statsObserver = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const number = entry.target.querySelector('.stat-number');
                const targetValue = parseInt(number.textContent);
                
                if (targetValue === 100) {
                    number.textContent = '100%';
                } else {
                    animateCounter(number, targetValue);
                }
                
                statsObserver.unobserve(entry.target);
            }
        });
    }, { threshold: 0.5 });

    document.querySelectorAll('.stat-item').forEach(item => {
        statsObserver.observe(item);
    });

    // Button click effects
    document.querySelectorAll('.btn, .card-btn').forEach(button => {
        button.addEventListener('click', function(e) {
            // Create ripple effect
            const ripple = document.createElement('span');
            const rect = this.getBoundingClientRect();
            const size = Math.max(rect.width, rect.height);
            const x = e.clientX - rect.left - size / 2;
            const y = e.clientY - rect.top - size / 2;
            
            ripple.style.cssText = `
                position: absolute;
                width: ${size}px;
                height: ${size}px;
                left: ${x}px;
                top: ${y}px;
                background: rgba(255, 255, 255, 0.3);
                border-radius: 50%;
                transform: scale(0);
                animation: ripple 0.6s linear;
                pointer-events: none;
            `;
            
            this.style.position = 'relative';
            this.style.overflow = 'hidden';
            this.appendChild(ripple);
            
            setTimeout(() => {
                ripple.remove();
            }, 600);
        });
    });

    // Add ripple animation CSS
    const style = document.createElement('style');
    style.textContent = `
        @keyframes ripple {
            to {
                transform: scale(4);
                opacity: 0;
            }
        }
    `;
    document.head.appendChild(style);

    // Code preview typing effect
    function typeCode() {
        const codeContent = document.querySelector('.code-content pre code');
        if (!codeContent) return;

        const fullCode = codeContent.innerHTML;
        codeContent.innerHTML = '';
        
        let i = 0;
        function typeChar() {
            if (i < fullCode.length) {
                codeContent.innerHTML += fullCode.charAt(i);
                i++;
                setTimeout(typeChar, 30);
            }
        }
        
        setTimeout(typeChar, 1000);
    }

    // Start typing effect when hero section is visible
    const heroObserver = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                typeCode();
                heroObserver.unobserve(entry.target);
            }
        });
    }, { threshold: 0.3 });

    const heroSection = document.querySelector('.hero');
    if (heroSection) {
        heroObserver.observe(heroSection);
    }

    // Pattern visualization animation
    function animatePatterns() {
        const patternRows = document.querySelectorAll('.pattern-row');
        
        patternRows.forEach((row, index) => {
            setTimeout(() => {
                row.style.opacity = '0';
                row.style.transform = 'translateX(-20px)';
                row.style.transition = 'all 0.3s ease';
                
                setTimeout(() => {
                    row.style.opacity = '1';
                    row.style.transform = 'translateX(0)';
                }, 100);
            }, index * 200);
        });
    }

    // Animate patterns when section is visible
    const patternsObserver = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                setTimeout(animatePatterns, 500);
                patternsObserver.unobserve(entry.target);
            }
        });
    }, { threshold: 0.3 });

    const patternsSection = document.querySelector('.patterns');
    if (patternsSection) {
        patternsObserver.observe(patternsSection);
    }

    // Card hover effects
    document.querySelectorAll('.algorithm-card, .project-card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-8px) scale(1.02)';
        });
        
        card.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0) scale(1)';
        });
    });

    // Floating shapes random movement
    function animateFloatingShapes() {
        const shapes = document.querySelectorAll('.shape');
        
        shapes.forEach(shape => {
            const randomX = Math.random() * 100 - 50;
            const randomY = Math.random() * 100 - 50;
            
            shape.style.transform = `translate(${randomX}px, ${randomY}px)`;
            shape.style.transition = 'transform 8s ease-in-out';
        });
    }

    // Start floating shapes animation
    setInterval(animateFloatingShapes, 8000);
    animateFloatingShapes();

    // Parallax effect for hero section
    window.addEventListener('scroll', function() {
        const scrolled = window.pageYOffset;
        const heroContent = document.querySelector('.hero-content');
        const heroVisual = document.querySelector('.hero-visual');
        
        if (heroContent && heroVisual) {
            heroContent.style.transform = `translateY(${scrolled * 0.1}px)`;
            heroVisual.style.transform = `translateY(${scrolled * 0.15}px)`;
        }
    });

    // Add loading animation
    window.addEventListener('load', function() {
        document.body.style.opacity = '0';
        document.body.style.transition = 'opacity 0.5s ease-in-out';
        
        setTimeout(() => {
            document.body.style.opacity = '1';
        }, 100);
    });

    // Initialize floating card animation
    const floatingCard = document.querySelector('.floating-card');
    if (floatingCard) {
        setInterval(() => {
            floatingCard.style.transform = `translateY(${Math.sin(Date.now() * 0.001) * 10}px)`;
        }, 50);
    }

    // Tech tag hover effects
    document.querySelectorAll('.tech-tag').forEach(tag => {
        tag.addEventListener('mouseenter', function() {
            this.style.background = 'rgba(59, 130, 246, 0.3)';
            this.style.transform = 'scale(1.05)';
        });
        
        tag.addEventListener('mouseleave', function() {
            this.style.background = 'rgba(59, 130, 246, 0.2)';
            this.style.transform = 'scale(1)';
        });
    });

    // Add cursor trail effect
    let trail = [];
    const trailLength = 20;

    document.addEventListener('mousemove', function(e) {
        trail.push({ x: e.clientX, y: e.clientY });
        
        if (trail.length > trailLength) {
            trail.shift();
        }
        
        // Update trail elements if they exist
        trail.forEach((point, index) => {
            const trailElement = document.getElementById(`trail-${index}`);
            if (trailElement) {
                trailElement.style.left = point.x + 'px';
                trailElement.style.top = point.y + 'px';
                trailElement.style.opacity = (index / trailLength) * 0.5;
            }
        });
    });

    console.log('🚀 InnoVision DSA website loaded successfully!');
    console.log('🎨 Modern dark theme with blue/purple gradients activated');
    console.log('⚡ Interactive elements initialized');
});

// Utility functions
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Performance optimization for scroll events
const optimizedScrollHandler = debounce(function() {
    // Scroll-based animations and effects
    const scrollY = window.scrollY;
    const windowHeight = window.innerHeight;
    
    // Update navbar
    const navbar = document.querySelector('.navbar');
    if (scrollY > 100) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
}, 10);

window.addEventListener('scroll', optimizedScrollHandler);