import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id: number;
  user:User
  constructor(private route: ActivatedRoute,private router: Router,
    private userService: UserService) {
      this.user = new User();

      this.id = this.route.snapshot.params['id'];
      
      this.userService.getUser(this.id)
        .subscribe(data => {
          console.log(data)
          this.user = data;
        }, error => console.log(error));
     }
  ngOnInit(): void {
  }
  updateUser() {
    this.userService.updateUser(this.id, this.user)
      .subscribe(data => {
        console.log(data);
        this.user = new User();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateUser();    
  }

  gotoList() {
    this.router.navigate(['/users']);
  }

}
