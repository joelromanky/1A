%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Analyse de données
% TP1 - Espace de représentation des couleurs
% Exercice_1.m
%--------------------------------------------------------------------------

clear
close all
clc

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

%% Décomposition des canaux RVB d'une image couleur

%I = imread('autumn.tif');          % 1er exemple
I = imread('gantrycrane.png');     % 2nd exemple

% Découpage de l'image en trois canaux et conversion en flottants
R = single(I(:,:,1));
V = single(I(:,:,2));
B = single(I(:,:,3));

%% Affichage de l'image RVB et de ses canaux

% 1ère fenêtre d'affichage
figure('Name','Separation des canaux RVB',...
       'Position',[0.01*L,0.1*H,0.59*L,0.75*H])

% Affichage de l'image RVB
    subplot(2,2,1)	% La fenêtre comporte 2 lignes et 2 colonnes
    imagesc(I)
    axis off image
    title('Image RVB','FontSize',20)
    
colormap gray % Pour afficher les images en niveaux de gris
              % Affichage avec la palette 'parula' par défaut sinon
    
% Affichage du canal R
    subplot(2,2,2) % 1ère ligne, 2ème colonne
    imagesc(R)
    axis off image
    title('Canal R','FontSize',20)
    
% Affichage du canal V
    subplot(2,2,3) % 2ème ligne, 1ère colonne
    imagesc(V)
    axis off image
    title('Canal V','FontSize',20)
    
% Affichage du canal B
    subplot(2,2,4) % 2ème ligne, 2ème colonne
    imagesc(B)
    axis off image
    title('Canal B','FontSize',20)
    
% Enregistrement des images des canaux
imwrite(uint8(R),'canal_R.png')
imwrite(uint8(V),'canal_V.png')
imwrite(uint8(B),'canal_B.png')

%% Affichage du nuage de pixels dans le repère RVB

% Deuxième fenêtre d'affichage
figure('Name','Nuage de pixels dans le repere RVB',...
       'Position',[0.61*L,0.1*H,0.38*L,0.6*H])

    plot3(R,V,B,'b.')
    axis equal
    grid on
    xlabel('R','FontWeight','bold')
    ylabel('V','FontWeight','bold')
    zlabel('B','FontWeight','bold')
    title({'Représentation 3D des pixels' ...
           'dans l''espace RVB'},'FontSize',20)
    rotate3d 

%% Calcul des corrélations entre les canaux RVB et des contrastes
    
% Matrice des données
X = [R(:) V(:) B(:)];	% Les trois canaux sont vectorisés et concaténés

% Matrice de variance/covariance
n = length(X);
Xbar = mean(X) ;
sigma = transpose(Xbar)*Xbar/n;


% Coefficients de corrélation linéaire
r_xy = sigma(1,2)/sqrt(sigma(1,1)*sigma(2,2));
r_yz = sigma(2,3)/sqrt(sigma(2,2)*sigma(3,3));
r_zx = sigma(1,3)/sqrt(sigma(3,3)*sigma(1,1));

% Proportions de contraste
s = sigma(1,1)+sigma(2,2) + sigma(3,3);
Cr = sigma(1,1)/s;
Cv = sigma(2,2)/s;
Cb = sigma(3,3)/s;
