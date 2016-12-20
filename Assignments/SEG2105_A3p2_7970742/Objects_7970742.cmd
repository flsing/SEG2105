Objects_7970742

!create uOttawa:University

!set uOttawa.name:='University Of Ottawa'
!set uOttawa.location:='Ottawa'

!create ComputerScience:Program

!set ComputerScience.name:='Computer Science'

!create Engineering:Department

!set Engineering.name:='Engineering'


!create Android:Course
!set Android.name:='Android Development'
!set Android.code:='CSI2244'


!create iOS:Course
!set iOS.name:='iOS Development'
!set iOS.code:='CSI2244'
!set iOS.year:= 2016



--links

!insert (uOttawa,ComputerScience) into ProgramOf
!insert (ComputerScience, Engineering) into belongsTo
!insert (Android, ComputerScience) into has
!insert (iOS, ComputerScience) into has

